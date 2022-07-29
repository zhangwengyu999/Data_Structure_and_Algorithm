public class cell {
    private int x;
    private int y;
    private cell[] nbCell = new cell[8]; // left_top,top,right_top,left,right,left_bottom,bottom,right_bottom
    private boolean live;
    private boolean nextLive;

    public cell(int inX, int inY) {
        x = inX;
        y = inY;
        for (int i = 0;i<8;i++) {
            nbCell[i] = this;
        }
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean equal(cell other) {
        return ((this.getX() == other.getX()) && (this.getY() == other.getY()));
    }

    public void setLeft(cell inCell) {
        nbCell[3] = inCell;
    }
    public void setRight(cell inCell) {
        nbCell[4] = inCell;
    }
    public void setTop(cell inCell) {
        nbCell[1] = inCell;
    }
    public void setBottom(cell inCell) {
        nbCell[6] = inCell;
    }
    public void setLeft_top(cell inCell) {
        nbCell[0] = inCell;
    }
    public void setRight_top(cell inCell) {
        nbCell[2] = inCell;
    }
    public void setLeft_bottom(cell inCell) {
        nbCell[5] = inCell;
    }
    public void setRight_bottom(cell inCell) {
        nbCell[7] = inCell;
    }

    public void setBorn() {
        nextLive = true;
    }
    public void setDie() {
        nextLive = false;
    }
    public int getCountLiveNb() {
        int count = 0;
        for (cell c : nbCell) {
            if (c.live && !c.equal(this)) {count++;}
        }
        return count;
    }
    public boolean isLive() {
        return live;
    }
    public void refresh() {
        if (getCountLiveNb()<2 || getCountLiveNb()>3) {
            this.setDie();
        }
        else if (getCountLiveNb() == 3) {
            this.setBorn();
        }
    }
    public void refreshLive() {
        live = nextLive;
    }
}
