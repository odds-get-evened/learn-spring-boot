import React from 'react';
import { createRoot } from 'react-dom/client';

const VApp = () => {
    return (
        <>
            <VehicleViewer/>
        </>
    );
};

const root = createRoot(document.getElementById('test-app'));
root.render(<VApp/>);