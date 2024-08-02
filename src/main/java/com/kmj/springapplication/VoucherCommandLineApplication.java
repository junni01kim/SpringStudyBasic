package com.kmj.springapplication;

import java.util.Scanner;

public class VoucherCommandLineApplication {
    VoucherService voucherService;


    public VoucherCommandLineApplication(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while(true){
            System.out.println("=== Voucher Program ===\n");
            System.out.println("Type **exit** to exit the program.\n");
            System.out.println("Type **create** to create a new voucher.\n");
            System.out.println("Type **list** to list all vouchers.\n");

            input = scanner.next();
            if(input.equalsIgnoreCase("exit")) break;
            switch (input) {
                case "create":
                    break;
                case "list":
                    break;
            }
        }
        System.out.println("VoucherCommandLineApplication 시스템을 종료합니다. \n");
    }
}
