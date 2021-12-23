import java.io.*;
import java.util.*;

public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;

	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	public Plot(Plot p) {
		x = p.getX();
		y = p.getY();
		width = p.getWidth();
		depth = p.getDepth();
	}

	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	public boolean overlaps(Plot plot) {

		boolean overlaps;
		int x1p1 = this.getX();

		int y1p1 = this.getY();

		int x2p1 = this.getX() + this.getWidth();

		int y2p1 = this.getY() + this.getDepth();

		int x1p2 = plot.getX();
		int y1p2 = plot.getY();
		int x2p2 = plot.getX() + plot.getWidth();
		int y2p2 = plot.getY() + plot.getDepth();

		if (x1p2 < x2p1 && x2p2 > x1p1 && y1p2 < y2p1 && y2p2 > y1p1)
			overlaps = true;
		else
			overlaps = false;

		return overlaps;
	}

	public boolean encompasses(Plot plot) {
		boolean encompasses;

		int x1p1 = this.getX();
		int x2p1 = this.getX() + this.getWidth();
		int y1p1 = this.getY();
		int y2p1 = this.getY() + this.getDepth();

		int x1p2 = plot.getX();
		int x2p2 = plot.getX() + plot.getWidth();
		int y1p2 = plot.getY();
		int y2p2 = plot.getY() + plot.getDepth();

		if (x1p1 <= x1p2 && y1p1 <= y1p2 && x2p1 >= x2p2 && y1p1 <= y2p2 && y2p1 >= y2p2)
			encompasses = true;
		else
			encompasses = false;

		return encompasses;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String toString() {
		String plotString = "";

		plotString = "Upper left: (" + this.x + "," + this.y + "); Width: " + this.width + " Depth: " + this.depth;

		return plotString;
	}

}