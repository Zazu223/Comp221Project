import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**The basic parent class "Feature," which all subclasses will use.
 * Subclasses will need to create their own "createSpriteList" function
 * to be able to be instantiated.*/

abstract public class Feature {

    //the variables include the sprite (image that appears on the canvas),
    //the size of the sprite on the canvas,
    //and a list of all the possible images that the sprite can appear as

    protected Image sprite;
    protected double size;
    protected ArrayList<Image> spriteList;    //since all spriteLists will be different, the variable is empty here

    protected Random random = new Random();   //this object will be used to generate random numbers

    Feature() {                 //all subclasses of Feature will automatically have to create their spriteList
        createSpriteList();     //and randomize their size and sprite when created, so these have been permanently
        randomizeSize();        //added to the Feature constructor (which the subclasses will use)
        randomizeSprite();
    }

    abstract protected void createSpriteList();     //since every spriteList will be different between
                                                    //the subclasses of Feature, there's no point in
                                                    //defining createSpriteList here

    protected void randomizeSprite() {                  //randomizeSprite uses the variable 'random' to create
        int index = random.nextInt(spriteList.size());  //a random integer less than or equal to the size of
        sprite = spriteList.get(index);                 //spriteList. The sprite variable is then assigned to
    }                                                   // the Image in spriteList at that index


    protected void randomizeSize() {                    //the variable 'random' is used again in randomizeSize
        size = random.nextFloat();                      //to choose a random decimal between 0 and 1 to represent
    }                                                   //the sprite's size (we can change the range later)

    protected void randomizeAll() {                     //a simple method that calls all randomizing functions
        randomizeSize();                                //in the Feature class. This can be overridden in any
        randomizeSprite();                              //subclasses that end up having extra randomizing methods
    }

    /**Getter functions*/                               //right now, there's no reason to let other classes set
                                                        //any of the variables, so only "getter" functions have
    public Image getSprite() {                          //been written
        return sprite;
    }

    public double getSize() {
        return size;
    }
}
