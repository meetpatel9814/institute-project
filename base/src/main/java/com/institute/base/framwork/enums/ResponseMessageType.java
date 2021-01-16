package com.institute.base.framwork.enums;

public enum ResponseMessageType {
  SUCCESS("SUCCESS"),
  ERROR("ERROR"),
  WARNING("WARNING");

  private final String message;

  ResponseMessageType(String message) {
    this.message = message;
  }
}
