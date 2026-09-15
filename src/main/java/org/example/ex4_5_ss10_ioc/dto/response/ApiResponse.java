package org.example.ex4_5_ss10_ioc.dto.response;

public class ApiResponse<T> {
    private String status;
    private int code;
    private T data;
    private PageMeta meta;

    public ApiResponse() {}

    public ApiResponse(String status, int code, T data, PageMeta meta) {
        this.status = status;
        this.code = code;
        this.data = data;
        this.meta = meta;
    }

    // Static helper method cho Success có phân trang
    public static <T> ApiResponse<T> success(T data, PageMeta meta) {
        return new ApiResponse<>("success", 200, data, meta);
    }

    // Static helper method cho Success không phân trang
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("success", 200, data, null);
    }

    // Static helper method cho Error
    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>("error", code, null, null);
    }

    // Getters & Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public PageMeta getMeta() { return meta; }
    public void setMeta(PageMeta meta) { this.meta = meta; }
}
