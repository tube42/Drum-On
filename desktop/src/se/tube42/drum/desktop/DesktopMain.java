
package se.tube42.drum.desktop;

import com.badlogic.gdx.backends.lwjgl.*;

import se.tube42.drum.*;

public class DesktopMain
{
    public static void main(String[] args )
    {
	/*
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DrumApp(), config);
	*/
        DrumApp app = new DrumApp();
        new LwjglApplication( app, "Drum On...", 400, 640);
    }

}
