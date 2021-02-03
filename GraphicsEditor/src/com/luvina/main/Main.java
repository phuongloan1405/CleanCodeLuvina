package com.luvina.main;

import com.luvina.impl.BMP;
import com.luvina.impl.GIF;
import com.luvina.impl.IFile;
import com.luvina.impl.JPG;
import com.luvina.impl.PNG;

public class Main {
	public static void main(String[] args) {
		IFile bmp = new BMP();
		IFile gif = new GIF();
		IFile jpg = new JPG();
		IFile png = new PNG();

		bmp.openFile();
		bmp.parseFile();
		bmp.saveFile();

		gif.openFile();
		gif.parseFile();
		gif.saveFile();

		jpg.openFile();
		jpg.parseFile();
		jpg.saveFile();

		png.openFile();
		png.parseFile();
		png.saveFile();

	}
}
