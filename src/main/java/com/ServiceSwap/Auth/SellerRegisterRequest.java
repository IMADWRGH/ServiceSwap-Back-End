package com.ServiceSwap.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerRegisterRequest {
    private byte[] img;
    private String address;
    private String Ville;
    private String phone;
    private String sexe;
    private String whatsappNumber;
    private String site;
}
