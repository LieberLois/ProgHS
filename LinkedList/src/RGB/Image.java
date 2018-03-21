package RGB;

public class Image {
    private String name;
    private final int width, height;
    private int[][] pixel;
    int RED = 0xff0000;
    int BLUE = 0x0000ff;

    public Image(String name, int width, int height){

        if(width <= 0 || height <= 0){
            this.width = 1920;
            this.height = 1080;
        } else {
            this.width = width;
            this.height = height;
        }

        this.name = name;
        pixel = new int[width][height];
    }

    public Image(){
        this.name = "Anonymous";
        this.width = 1920;
        this.height = 1080;
        pixel = new int[width][height];
    }

    public void setPixel(int x, int y, int c){
        if ((x > 0 && x <= width) && (y > 0 && y <= height)) {
            pixel[x][y] = c;
        }
    }

    public void fillRect(int x1, int x2, int y1, int y2, int c){
        for(int i = x1; i<(x2); i++){
            for(int j = y1; j<(y2); j++){
                pixel[i][j] = c;
            }
        }
    }

    public double averageRedIntesity(){
        double red = 0;

        for(int i = 0; i<(width+1); i++){
            for(int j = 0; j<(height+1); j++){
                red += (pixel[i][j] >> 16) & 0x000000FF;
            }
        }

        return red/(width*height);
    }

    public int howManySameColors(int x, int y){
        int color = 0;
        int counter = 0;

        if ((x > 0 && x <= width) && (y > 0 && y <= height)) {
            color = pixel[x][y];
        }

        for(int i = x; i < width; i++){
            if(pixel[i][y] == color){
                counter++;
            }
        }

        return counter;

    }



    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHeigth(){
        return height;
    }

    public int getWidth(){
        return width;
    }
}
