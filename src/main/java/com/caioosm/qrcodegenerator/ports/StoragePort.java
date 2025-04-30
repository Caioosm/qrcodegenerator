package com.caioosm.qrcodegenerator.ports;

public interface StoragePort {
    String uploadFile(Byte[] fileData, String fileName, String contentType);
}
