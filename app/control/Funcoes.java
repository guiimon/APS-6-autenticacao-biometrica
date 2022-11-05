package app.control;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.machinezoo.sourceafis.FingerprintImage;
import com.machinezoo.sourceafis.FingerprintImageOptions;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

public class Funcoes extends Component{

    public boolean ComparaDigital(File imgLogin, File imgBanco) throws IOException {
     
		FingerprintTemplate probe = new FingerprintTemplate(
                new FingerprintImage(
                        Files.readAllBytes(Paths.get(imgLogin.getPath())),
                        new FingerprintImageOptions()
                                .dpi(500)));

        FingerprintTemplate candidate = new FingerprintTemplate(
                new FingerprintImage(
                        Files.readAllBytes(Paths.get(imgBanco.getPath())),
                        new FingerprintImageOptions()
                                .dpi(500)));

        double score = new FingerprintMatcher(probe)
                .match(candidate);
        boolean matches = score >= 40;
        System.out.println(matches);
        return matches;

    }

}
