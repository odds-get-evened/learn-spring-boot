package gov.ny.its.mentor_demo.util;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHAPasswordEncoder implements PasswordEncoder {
	private static SHAMode TYPE = SHAMode.SHA256;

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			MessageDigest dig = MessageDigest.getInstance(TYPE.getLabel());
			dig.update(rawPassword.toString().getBytes(StandardCharsets.UTF_8));

			return Base64.getEncoder().encodeToString(dig.digest());
		} catch (NoSuchAlgorithmException e) {
			return rawPassword.toString();
		}
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		try {
			MessageDigest d = MessageDigest.getInstance(TYPE.getLabel());
			d.update(rawPassword.toString().getBytes(StandardCharsets.UTF_8));

			String enc = Base64.getEncoder().encodeToString(d.digest());

			return enc.equals(encodedPassword);
		} catch (NoSuchAlgorithmException e) {
			return false;
		}
	}
}
