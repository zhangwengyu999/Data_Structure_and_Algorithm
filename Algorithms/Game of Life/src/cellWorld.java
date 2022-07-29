public class cellWorld {
    private int width; // x
    private int height; // y
    private cell[][] storage; // [y][x]
    cellWorld (int inH, int inW) {
        height = inH;
        width = inW;
        storage = new cell[inH][inW];
        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                storage[i][j] = new cell(j,i);
            }
        }
        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                getLined(storage[i][j]);
            }
        }

    }

    public void add(cell inCell) {
        storage[inCell.getY()][inCell.getX()].setBorn();
        storage[inCell.getY()][inCell.getX()].refreshLive();

    }

    public void getLined(cell inCell) {
        cell theCell = storage[inCell.getY()][inCell.getX()];
        //storage[inCell.getY()][inCell.getX()].setBorn();

        if(theCell.getX()!=0) {
            theCell.setLeft(storage[inCell.getY()][inCell.getX()-1]);
            if (theCell.getY()!=0) {
                theCell.setTop(storage[inCell.getY()-1][inCell.getX()]);
                theCell.setLeft_top(storage[inCell.getY() - 1][inCell.getX() - 1]);
            }
            if (theCell.getY()!=height-1) {
                theCell.setBottom(storage[inCell.getY()+1][inCell.getX()]);
                theCell.setLeft_bottom(storage[inCell.getY() + 1][inCell.getX() - 1]);
            }
        }
        if(theCell.getX()!=width-1) {
            theCell.setRight(storage[inCell.getY()][inCell.getX()+1]);
            if (theCell.getY()!=0) {
                theCell.setTop(storage[inCell.getY()-1][inCell.getX()]);
                theCell.setRight_top(storage[inCell.getY() - 1][inCell.getX() + 1]);
            }
            if (theCell.getY()!=height-1) {
                theCell.setBottom(storage[inCell.getY()+1][inCell.getX()]);
                theCell.setRight_bottom(storage[inCell.getY() + 1][inCell.getX() + 1]);
            }
        }
    }

    public void refresh() {
        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                storage[i][j].refresh();
            }
        }
        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                storage[i][j].refreshLive();
            }
        }
    }

    public void listAll() {
        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                if (storage[i][j].isLive()) {
                    System.out.print("X  ");
                }
                else {
                    System.out.print("·  ");
                }
            }
            System.out.println("");
        }

    }

}
