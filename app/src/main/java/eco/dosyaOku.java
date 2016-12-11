
package eco;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by cenk.akdeniz on 14.04.2016.
 */
public class dosyaOku {

    Context mContext;
    Context mContextDis;
    File file = new File("dosya.txt");
    public void dosyayaYazma(){
        String str = "Bunu dosyaya yazdir";

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(str);
            bWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Certificates> dosyadanOkumaCer(Context context , String dosya){
        ArrayList<Certificates> veri = null;
        mContext = context;
        InputStream is = null;
        try {

            veri =  new ArrayList<Certificates>();
            is = mContext.getAssets().open(dosya);
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line=br.readLine()) != null) {
                String tmp []= line.split("--");
                veri.add(new Certificates(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]));
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return veri;

    }

    public ArrayList<Diseases> dosyadanOkumaDis(Context context , String dosya){
        ArrayList<Diseases> veriDis = null;
        mContext = context;
        InputStream is = null;
        try {

            veriDis = new ArrayList<Diseases>();
            is = mContext.getAssets().open(dosya);
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line=br.readLine()) != null) {
                String temp [] = line.split("--");
                veriDis.add(new Diseases(temp[0], temp[1] ,temp[2]));
            }
            System.out.println(veriDis);
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return veriDis;

    }



}
