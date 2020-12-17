//store the actual image wht the window should show(even ghost should do this)
//responsible for its own speed and location and directions

//a pacman is 50x50 pixells


public class Pacman {

    private String path_Left="pac_left.png";
    private String path_Up="pac_up.png";
    private String path_Right="pac_right.png";
    private String path_Down="pac_down.png";
    private String path_Full="pac_full.png";

    public Pacman(){
    }


    public String getPath_Left() {
        return path_Left;
    }

    public String getPath_Up() {
        return path_Up;
    }

    public String getPath_Right() {
        return path_Right;
    }

    public String getPath_Down() {
        return path_Down;
    }

    public String getPath_Full() {
        return path_Full;
    }
}
