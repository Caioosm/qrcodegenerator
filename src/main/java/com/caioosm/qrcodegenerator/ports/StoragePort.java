package com.caioosm.qrcodegenerator.ports;

public interface StoragePort {
    String uploadFile(byte[] fileData, String fileName, String contentType);
}
