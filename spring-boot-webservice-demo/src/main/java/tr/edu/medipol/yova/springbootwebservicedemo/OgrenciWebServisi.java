package tr.edu.medipol.yova.springbootwebservicedemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OgrenciWebServisi {

    public record Ogrenci(String numara, String name) {}

    private static List<Ogrenci> OGRENCILER = new ArrayList<>();
    static {
        OGRENCILER.add(new Ogrenci("1", "Ali"));
        OGRENCILER.add(new Ogrenci("2", "Mehmet"));
    }

    @GetMapping("/")
    public List<Ogrenci> listele() {
        return OGRENCILER;
    }

    @PostMapping("/")
    public void ekle(@RequestBody Ogrenci yeniOgrenci) {
        OGRENCILER.add(yeniOgrenci);
    }
    
    @DeleteMapping("/{numara}")
    public boolean sil(@PathVariable String numara) {
        for(Ogrenci ogrenci: OGRENCILER) {
            if(ogrenci.numara.equals(numara)) {
                OGRENCILER.remove(ogrenci);
                return true;
            }
        }
        return false;
    }
}
