package gov.ny.its.mentor_demo.controller;

import gov.ny.its.mentor_demo.entity.AlbumEntity;
import gov.ny.its.mentor_demo.repo.AlbumRepo;
import gov.ny.its.mentor_demo.repo.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MusicController {
	@Autowired
	private ArtistRepo artistRepo;

	@Autowired
	private AlbumRepo albumRepo;

	@GetMapping("/music")
	public String getMusic(Model m) {
		m.addAttribute("albums", albumRepo.findAll());

		return "music/home";
	}

	@GetMapping("/music/album/details")
	public String albumDetails(@RequestParam(value = "id") Long id,  Model m) {
		AlbumEntity a = albumRepo.findById(id).get();
		//List<ArtistEntity> b = artistRepo.findByAlbumId(id);
		m.addAttribute("album", a);
		//m.addAttribute("artists", b);

		return "music/album-details";
	}
}
