import org.junit.Test;

import static org.junit.Assert.*;

public class cellWorldTest {

    @Test
    public void lifeTest1() {
        cellWorld newWorld = new cellWorld(3,3);
        cell c1 = new cell(0,1);
        newWorld.add(c1);
        cell c2 = new cell(1,1);
        newWorld.add(c2);
        cell c3 = new cell(2,1);
        newWorld.add(c3);
        while (true) {
            try{
                newWorld.listAll();
                System.out.println("");
                newWorld.refresh();
                Thread.sleep(1000);
            }
            catch (Exception e) {}
        }
    }

    @Test
    public void lifeTest2() {
        cellWorld newWorld = new cellWorld(4,4);
        cell c1 = new cell(1,1);
        cell c2 = new cell(1,2);
        cell c3 = new cell(2,1);
        cell c4 = new cell(2,2);
        newWorld.add(c1);
        newWorld.add(c2);
        newWorld.add(c3);
        newWorld.add(c4);
        while (true) {
            try{
                newWorld.listAll();
                System.out.println("");
                newWorld.refresh();
                Thread.sleep(1000);
            }
            catch (Exception e) {}
        }
    }

    @Test
    public void lifeTest3() {
        cellWorld newWorld = new cellWorld(5,5);
        cell c1 = new cell(2,1);
        cell c2 = new cell(1,2);
        cell c3 = new cell(3,2);
        cell c4 = new cell(2,3);
        newWorld.add(c1);
        newWorld.add(c2);
        newWorld.add(c3);
        newWorld.add(c4);
        while (true) {
            try{
                newWorld.listAll();
                System.out.println("");
                newWorld.refresh();
                Thread.sleep(1000);
            }
            catch (Exception e) {}
        }
    }

    @Test
    public void lifeTest4() {
        cellWorld newWorld = new cellWorld(15,15);
        cell c1 = new cell(2,0);
        cell c2 = new cell(0,1);
        cell c3 = new cell(2,1);
        cell c4 = new cell(1,2);
        cell c5 = new cell(2,2);
        newWorld.add(c1);
        newWorld.add(c2);
        newWorld.add(c3);
        newWorld.add(c4);
        newWorld.add(c5);
        while (true) {
            try{
                newWorld.listAll();
                System.out.println("");
                newWorld.refresh();
                Thread.sleep(1000);
            }
            catch (Exception e) {}
        }
    }

}