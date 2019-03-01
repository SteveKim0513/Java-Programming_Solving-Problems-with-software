import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public int getNumPoints (Shape s) {
        int count = 0;
        for(Point currPt : s.getPoints()) {
            count ++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        return getPerimeter(s) / getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        double largeside = 0.0;
        Point prevPt = s.getLastPoint();
        
        for(Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if(currDist > largeside) largeside = currDist;
            prevPt = currPt;
        }
        return largeside;
    }

    public double getLargestX(Shape s) {
        Point prevPt = s.getLastPoint();
        double prevX = prevPt.getX();
        double largeX = 0;
        
        for(Point currPt : s.getPoints()){
            double currX = currPt.getX();
            if(currX > prevX) largeX = currX;
            prevPt = currPt;
        }
        return largeX;
    }

    public double getLargestPerimeterMultipleFiles(DirectoryResource dr) {
        double largePeri = 0.0;
        
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPeri = getPerimeter(s);
            
            if(currPeri > largePeri) largePeri = currPeri;
        }
        return largePeri;
    }

    public String getFileWithLargestPerimeter(DirectoryResource dr) {
        double largePeri = getLargestPerimeterMultipleFiles(dr);
        String filename = null;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            
            double currPeri = getPerimeter(s);
            
            if(currPeri == largePeri) {
                filename = f.getName();
                break;
            }
        }
        return filename;
    }

    /** public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    } */
    
    
    public void testAllFile(){
        DirectoryResource dr = new DirectoryResource();
        double largeP = getLargestPerimeterMultipleFiles(dr);
        String largeFname = getFileWithLargestPerimeter(dr);
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            
            int num_point = getNumPoints(s);
            double peri = getPerimeter(s);
            double averge_peri = getAverageLength(s);
            double largeside = getLargestSide(s);
            
            System.out.println(f.getName() + " number of point = " + num_point);
            System.out.println(f.getName() + " perimeter = " + peri);
            System.out.println(f.getName() + " average = " + averge_peri);
            System.out.println(f.getName() + " largeside = " + largeside);
        }
    
        System.out.println("largest perimeter = " + largeP + " of " + largeFname);
    }
        
    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testAllFile();
    }
}
