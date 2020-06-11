package com.example.clocksystem.exception;

public class PermissionException extends BaseException {
    public PermissionException() {
        super(404, "权限不足", null);
    }
}
