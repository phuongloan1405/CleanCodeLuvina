package com.luvina.impl;

public class JPG implements IFile {

	@Override
	public void openFile() {
		System.out.println("Open file by JPG");

	}

	@Override
	public void parseFile() {
		System.out.println("Pasre file by JPG");

	}

	@Override
	public void saveFile() {
		System.out.println("Save file by JPG");

	}

}
