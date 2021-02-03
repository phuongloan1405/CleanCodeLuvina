package com.luvina.impl;

public class PNG implements IFile {

	@Override
	public void openFile() {
		System.out.println("Open file by PNG");

	}

	@Override
	public void parseFile() {
		System.out.println("Pasre file by PNG");

	}

	@Override
	public void saveFile() {
		System.out.println("Save file by PNG");

	}
}
