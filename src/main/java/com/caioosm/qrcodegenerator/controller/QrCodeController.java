package com.caioosm.qrcodegenerator.controller;

import com.caioosm.qrcodegenerator.dto.qrcode.QrCodeGenerateRequest;
import com.caioosm.qrcodegenerator.dto.qrcode.QrCodeGenerateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generateQrCode(@RequestBody QrCodeGenerateRequest qrCodeGenerateRequest) {
        return null;
    }

}
