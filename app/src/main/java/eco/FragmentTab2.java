package eco;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.R;

import java.util.Locale;

public class FragmentTab2 extends Fragment
{
	Button btnCamera ,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
	TextView warning_text;
	private PopupWindow popupWindow;
	private LayoutInflater layoutInflater;
	LinearLayout linear;
	int width;
	int height;

	String ready_soup="ready soups are consist of too much additives so it leads various kind of diseases.People have to avoid from ready soups , especially kids.";
	String hazir_corba = "hazır çorbalar çeşitli katkı maddeleri içerir ,bu yüzden çok çeşitli hastalıklara sebep olabilir." +
			"Sağlığınız için hazır çorba tüketiminden kaçının.Özellikle çocuklarınızı hazır çorbalardan uzak tutun!!!";
	String pizza_en ="pizzas include carbohydrate ve saturated fat.It leads to get extra and unhealthy weignht gain";
	String pizza_tr ="pizzalar karbonhidrat ve doymuş yağ içerdiğinden ekstra ve sağlıksız kilo alımına neden olur.";
	String hamburger_en = "Kids consume too much hamburger have more risk to getting Asthma disease";
	String hamburger_tr="Çok fazla hamburger tüketen çocuklarda astım hastalığının görülme riski daha fazladır";
	String beer = "Consumption of alcohol damage to liver.It may cause cirrhosis";
	String bira = "Alkol tüketimi karaciğerinize zarar verir ve siroz hastalığına neden olabilir";
	String preserve = "Preserves includes additives for long term protection and too much consumption of preserves may cause hypertension ,cancer ,obesity ,heart diseases";
	String konserveler = "Konserveler uzun süre bozulmadan muhafaza edilmesi için katkı maddeleri içerir ve bu karkı maddeleri hipertansiyon , kanser ,obezite ve kanser hastalıklarına sebep olabilir.";
	String desserts = "Consumption of desserts may cause diabetes ,heart attack and cancer.";
	String tatlılar = "Tatlı tüketimi kanser ,kalp krizi ve diyabet hastalığına neden olabilir";
	String fried_potatoes = "Consumption of fried potatoes cause arteriosclerosis and embolism " ;
	String patates_kizartmesi = "Patates kızartması tüketmek damar sertliğine ve damar tıkanıklığına neden olabilir!!!";
	String crisps = "Consumption of crisps may cause  obesity ,cancer ,diabete  ,alzheimer diseases.Especially kids should avoid from crisps";
	String cips = "Cips tüketimi obezite ,kanser ,diyabet ve alheimer gibi hastalıklara sebep olabilir.özellikle çocuklar cips yemekten kaçınmalıdır.";
	String coke = "Coke protect the secret of it's formula.It has a chemical make people addict.It may cause dental , heart , obesite ,bone diseases";
	String kola = "Kola formülünün sırrını hala koruyor ve bağımlılık yapan bir kimyasal barındırdığı biliniyor.Kola diş ,kalp ,obezite ve kemik hastalıklarına neden olabiliyor.";
	String vending_machine = "Biscuits and cracker contains additives.They are very dangerous for babies.You can prepare natural biscuits and save yout baby's health.";
	String otomat = "Bisküviler ve krakerler çok fazla katkı maddesi içerir ve bebekleriçin tehlikelidir.Bebeğiniz için evde doğal bisküviler hazırlayabilir ve " +
			"onun sağlığını koruyabilirsiniz";




	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// Get the view from fragmenttab2.xml
		View view = inflater.inflate(R.layout.fragmenttab2, container, false);

		btnCamera=(Button) view.findViewById(R.id.camera_button) ;
		btn1=(Button) view.findViewById(R.id.icon1);
		btn2=(Button) view.findViewById(R.id.icon2);
		btn3=(Button) view.findViewById(R.id.icon3);
		btn4=(Button) view.findViewById(R.id.icon4);
		btn5=(Button) view.findViewById(R.id.icon5);
		btn6=(Button) view.findViewById(R.id.icon6);
		btn7=(Button) view.findViewById(R.id.icon7);
		btn8=(Button) view.findViewById(R.id.icon8);
		btn9=(Button) view.findViewById(R.id.icon9);
		btn10=(Button) view.findViewById(R.id.icon10);

		linear = (LinearLayout) view.findViewById(R.id.LinearL);

		Display display = getActivity().getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		width = ((size.x)/10)*6;
		height = ((size.y)/10)*4;

		ConnectivityManager cm =
				(ConnectivityManager)getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

		//NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		//boolean isConnected = activeNetwork != null &&
		//		activeNetwork.isConnectedOrConnecting();

		btnCamera.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent intent = new Intent(getActivity(), CaptureActivity.class);
				startActivity(intent);
			}
		});

		btn1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER, 0 ,50);
				warning_text = (TextView) popupWindow.getContentView().findViewById(R.id.txtPopup);

				if(Locale.getDefault().getLanguage().equals("en")) {
					warning_text.setText(ready_soup);
				}
				else if(Locale.getDefault().getLanguage().equals("tr")){
					warning_text.setText(hazir_corba);
				}

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});

		btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);
				warning_text = (TextView) popupWindow.getContentView().findViewById(R.id.txtPopup);

				if(Locale.getDefault().getLanguage().equals("en")) {
					warning_text.setText(hamburger_en);
				}
				else if(Locale.getDefault().getLanguage().equals("tr")){
					warning_text.setText(hamburger_tr);
				}


				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});


		btn3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);
				warning_text = (TextView) popupWindow.getContentView().findViewById(R.id.txtPopup);

				if(Locale.getDefault().getLanguage().equals("en")) {
					warning_text.setText(pizza_en);
				}
				else if(Locale.getDefault().getLanguage().equals("tr")){
					warning_text.setText(pizza_tr);
				}


				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});


		btn4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);
				warning_text = (TextView) popupWindow.getContentView().findViewById(R.id.txtPopup);

				if(Locale.getDefault().getLanguage().equals("en")) {
					warning_text.setText(preserve);
				}
				else if(Locale.getDefault().getLanguage().equals("tr")){
					warning_text.setText(konserveler);
				}

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);
				warning_text = (TextView) popupWindow.getContentView().findViewById(R.id.txtPopup);

				if(Locale.getDefault().getLanguage().equals("en")) {
					warning_text.setText(beer);
				}
				else if(Locale.getDefault().getLanguage().equals("tr")){
					warning_text.setText(bira);
				}

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);
				warning_text = (TextView) popupWindow.getContentView().findViewById(R.id.txtPopup);

				if(Locale.getDefault().getLanguage().equals("en")) {
					warning_text.setText(desserts);
				}
				else if(Locale.getDefault().getLanguage().equals("tr")){
					warning_text.setText(tatlılar);
				}

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);
				warning_text = (TextView) popupWindow.getContentView().findViewById(R.id.txtPopup);

				if(Locale.getDefault().getLanguage().equals("en")) {
					warning_text.setText(fried_potatoes);
				}
				else if(Locale.getDefault().getLanguage().equals("tr")){
					warning_text.setText(patates_kizartmesi);
				}


				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn8.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);
				warning_text = (TextView) popupWindow.getContentView().findViewById(R.id.txtPopup);

				if(Locale.getDefault().getLanguage().equals("en")) {
					warning_text.setText(crisps);
				}
				else if(Locale.getDefault().getLanguage().equals("tr")){
					warning_text.setText(cips);
				}

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn9.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);
				warning_text = (TextView) popupWindow.getContentView().findViewById(R.id.txtPopup);

				if(Locale.getDefault().getLanguage().equals("en")) {
					warning_text.setText(coke);
				}
				else if(Locale.getDefault().getLanguage().equals("tr")){
					warning_text.setText(kola);
				}

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn10.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);
				warning_text = (TextView) popupWindow.getContentView().findViewById(R.id.txtPopup);

				if(Locale.getDefault().getLanguage().equals("en")) {
					warning_text.setText(vending_machine);
				}
				else if(Locale.getDefault().getLanguage().equals("tr")){
					warning_text.setText(otomat);
				}

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		return view;
	}

}
