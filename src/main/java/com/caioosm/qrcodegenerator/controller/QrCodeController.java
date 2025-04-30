package com.caioosm.qrcodegenerator.controller;

import com.caioosm.qrcodegenerator.dto.qrcode.QrCodeGenerateRequest;
import com.caioosm.qrcodegenerator.dto.qrcode.QrCodeGenerateResponse;
import com.caioosm.qrcodegenerator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generateQrCode(@RequestBody QrCodeGenerateRequest qrCodeGenerateRequest) {
        try {
            QrCodeGenerateResponse response =  this.qrCodeGeneratorService.generateAndUploadQrCode(qrCodeGenerateRequest.text());
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
