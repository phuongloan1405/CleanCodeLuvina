package com.luvina.impl;

public class GIF implements IFile {

	@Override
	public void openFile() {
		System.out.println("Open file by GIF");

	}

	@Override
	public void parseFile() {
		System.out.println("Pasre file by GIF");

	}

	@Override
	public void saveFile() {
		System.out.println("Save file by GIF");

	}

}
