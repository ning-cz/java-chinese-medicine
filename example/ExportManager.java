package org.example;

import java.io.*;
import java.util.*;

public class ExportManager {
    public void exportPrescriptions(List<Prescription> prescriptions, ExportType type, String filePath) throws IOException {
        switch (type) {
            case TXT:
                exportTxt(prescriptions, filePath);
                break;
            case CSV:
                exportCsv(prescriptions, filePath);
                break;
            case PDF:
                // TODO: PDF导出
                break;
        }
    }

    private void exportTxt(List<Prescription> list, String filePath) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Prescription p : list) {
                pw.println("药方名: " + p.getName());
                pw.println("主治: " + p.getMainEffect());
                pw.println("药材: " + p.getMedicineNames());
                pw.println("人气: " + p.getPopularity());
                pw.println("------");
            }
        }
    }

    private void exportCsv(List<Prescription> list, String filePath) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.println("药方名,主治,药材,人气");
            for (Prescription p : list) {
                pw.printf("%s,%s,%s,%d\n",
                        p.getName(), p.getMainEffect(), p.getMedicineNames(), p.getPopularity());
            }
        }
    }
}

