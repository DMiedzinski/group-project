package com.github.java3wro.project.badugi.enums;

public enum MoveType {
    CHECK("check"),RISE("rise"),WAIT("wait"),PASS("pass"),SB("sb"),BB("bb");


	private String type;
	
	MoveType(String type) {
		this.type = type;
	}
	
	public static MoveType getEnum(String type) {
		switch (type) {
			case "wait":
				return MoveType.WAIT;
			case "check":
				return MoveType.CHECK;
			case "rise":
				return MoveType.RISE;
			case "pass":
				return MoveType.PASS;
			default:
				return null;
		}
	}
}
