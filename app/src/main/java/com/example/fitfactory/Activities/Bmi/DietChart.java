package com.example.fitfactory.Activities.Bmi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitfactory.R;


import java.util.ArrayList;

public class DietChart extends AppCompatActivity {
    RecyclerView recyclerChart;
    ArrayList<BmiCalculator.Menu> arrayList = new ArrayList<>();
    ChartAdapter chartAdapter;
    TextView head;
    String titleRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_chart);
        head = findViewById(R.id.head);
        recyclerChart = findViewById(R.id.recyclerChart);
        Boolean check = getIntent().getBooleanExtra("TitleCheck", false);
        Boolean check1 = getIntent().getBooleanExtra("TypeCheck", false);
        if (check == true) {
            titleRec = getIntent().getStringExtra("TitleSent");
        } else if (check1 == true) {

            titleRec = getIntent().getStringExtra("TypeSent");
        } else {
            titleRec = "";
        }


        head.setText(titleRec);
        if (titleRec.equals("Healthy")) {


            arrayList.add(new BmiCalculator.Menu("Sunday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast " + "\n" + "(8:00-8:30AM)", "Aloo Paratha (2) + Raita (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup moong dal + 1 cup bhindi + 2 chapatti + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "Tea/ Coffee (1 cup) + Boiled Chana Chat (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "Chapati (2) + Jeera Aloo (1 cup)"));

            arrayList.add(new BmiCalculator.Menu("Monday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Chapati (2) + Daal (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup rajma + 1 cup gobhi aloo + 1 cup cucumber raita + 1 cup rice + 1 chapatti + onion salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "Tea/ Coffee (1 cup) + Aloo Chat (1 cup"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "Chapati (2) + Mix Veg."));

            arrayList.add(new BmiCalculator.Menu("Tuesday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Aloo Paratha (2) + Raita (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup soy bean curry + 1 cup tinda vegetable + 2 chapatti + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "Tea/ Coffee (1 cup) + Boiled Chana Chat (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "Chapati (2) + Bottle Gourd Curry (1 cup)"));

            arrayList.add(new BmiCalculator.Menu("Wednesday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Veg. Poha (1 cup) + Raita (1/2 cup"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup white chana + palak paneer + 1 cup rice + 1 chapatti + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "Tea/ Coffee (1 cup) + Mur-mure Chat (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "Chapati (2) + Mustard Greens (1 cup)"));

            arrayList.add(new BmiCalculator.Menu("Thursday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Cheela (2) + Raita (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup chicken curry/Aloo sabji + 1 cup boiled rice + 2 chapatti + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "Tea/ Coffee (1 cup) + Papri Chat (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "Chapati (2) +  Soya Curry (1 cup)"));

            arrayList.add(new BmiCalculator.Menu("Friday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Chapati (2) + Daal (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup fish curry/Panner curry + 1 cup boiled rice + 1 chapatti + 1 cup ghia raita + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "Tea/ Coffee (1 cup) + Aloo Chat (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "Chapati (2) + Matar n Mushroom Curry (1 cup)"));

            arrayList.add(new BmiCalculator.Menu("Saturday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Veg Upma (1 cup) + Raita (1/2 cup)"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup chicken curry/Fixed veg + 1 cup rice + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "Tea/ Coffee (1 cup) + Papri Chat (1 cup)"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "Chapati (2) + Kofta (1 cup)"));


        }
        if (titleRec.equals("Under Weight")) {

            arrayList.add(new BmiCalculator.Menu("Sunday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "2 egg brown bread sandwich + green chutney + 1 cup milk + 3 cashews +1 cup banana shake+ 4 almonds + 2 walnuts"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup arhar dal + 1 cup potato curry + 3 chapatti + 1/2 cup rice + 1/2 cup low fat curd + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "1 cup strawberry smoothie + 1 cup vegetable poha"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "1.5 cup chicken curry + 3 chapatti + salad"));

            arrayList.add(new BmiCalculator.Menu("Monday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "3 onion stuffed parantha + 1 cup curd + 3 cashews + 4 almonds + 2 walnuts"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup moong dal/ chicken curry + 1 cup potato and caulifllower vegetable + 3 chapatti + 1/2 cup rice + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "1 cup pomegranate juice + 2 butter toasted bread"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "1 cup beans potato vegetable + 3 chapatti + salad"));


            arrayList.add(new BmiCalculator.Menu("Tuesday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "3 paneer stuffed besan cheela + green chutney + 1 cup curd + 3 cashews + 4 almonds + 2 walnuts"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup masoor dal + 1 cup calocasia + 3 chapatti + 1/2 cup rice + 1 cup low curd + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "1 cup tomato soup with bread crumbs + 1 cup aloo chaat"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "1 cup carrot peas vegetable +3 chapatti + salad"));


            arrayList.add(new BmiCalculator.Menu("Wednesday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "1.5 cup vegetable bread upma + 1 cup milk + 3 cashews + 4 almonds + 2 walnuts"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup rajma curry + 1 cup spinach potato + 3 chapatti + 1/2 cup rice + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "1 cup vegetable juice + 1 cup upma"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "1.5 cup parwal vegetable + 3 chapatti + salad"));

            arrayList.add(new BmiCalculator.Menu("Thursday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "2 cucmber potato sandwich + 1 tsp green chutney + 1 orange juice + 3 cshews + 2 walnuts + 4 almond"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup white chana/ fish curry + 3 chapatti + 1/2 cup rice + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "1 cup almond milk + banana"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "1 cup cauliflower potato vegetable + 3 chapatti + salad"));

            arrayList.add(new BmiCalculator.Menu("Friday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "2 cup vegetable poha + 1 cup curd + 3 cashews + 4 almonds + 2 walnuts"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", " 1 cup chana dal + 1 cup bhindi vegetable + 3 chapatti + 1/2 cup rice + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "1 cup sprouts salad + 2 potato cheela + green chutney"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "1 cup peas mushroom vegetable + 3 chapatti + salad"));


            arrayList.add(new BmiCalculator.Menu("Saturday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "3 vegetable suji cheela + 1 cup strawberry shake + 4 cashews + 4 almonds + 3 walnuts"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "1 cup mix dal + 1 cup soybean curry + 3 chapatti + 1/2 cup curd + salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "1 cup fruit salad + 4 pc vegetable cutlets + green chutn"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "1 cup karela vegetable + 3 chaptti + salad"));


        }

        if (titleRec.equals("Over Weight") || titleRec.equals("Obese")) {


            arrayList.add(new BmiCalculator.Menu("Sunday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Brown rice idli, sambhar, a spoonful of coconut chutney/two whole eggs, one toast with unsweetened tea/coffee"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "One whole-grain chapati, dal, mixed vegetable curry, a bowl of salad/one whole-grain chapati turned into a tortilla with chicken stuffing"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "5 almonds and two dates, a glass of buttermilk"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "One large bowl of soup with sautéed tofu/paneer/chicken"));

            arrayList.add(new BmiCalculator.Menu("Monday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Chana/Moong dal pancakes with paneer stuffing/scrambled eggs with toast and unsweetened tea/coffee"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "Brown rice with chickpea gravy/chicken gravy and a cup of sauteed vegetables"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "5 almonds and 2 dates, a glass of unsweetened milk"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "One bowl of khichdi and spinach salad"));

            arrayList.add(new BmiCalculator.Menu("Tuesday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Porridge with fruits and milk/omelette with one plain roti and unsweetened tea/coffee"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "Whole-grain chapati with paneer gravy/chicken gravy and vegetable salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "5 almonds and 2 dates, a glass of buttermilk"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "One bowl of brown rice with palak-paneer/steamed fish"));

            arrayList.add(new BmiCalculator.Menu("Wednesday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Oats and milk with fruits and unsweetened tea/coffee"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "Whole-grain chapati with vegetable soup/chicken soup with vegetable salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "5 almonds and 2 dates, a glass of milk"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "Tandoori paneer with fresh veg salad / tandoori fish or chicken with fresh veg salad"));

            arrayList.add(new BmiCalculator.Menu("Thursday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Oats with yoghurt and fruits/Spanish vegetable omelette with toast and unsweetened tea/coffee"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "Whole-grain chapati with lentil gravy and veg sabzi/sautéed chicken roti wrap with salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "5 almonds and 2 dates, a glass of milk (unsweetened)"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "One bowl of brown rice with channa masala/chicken masala and green salad"));

            arrayList.add(new BmiCalculator.Menu("Friday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Vegetable daliya/French toast and unsweetened tea/coffee"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "Sambhar rice/chicken stew with appam and vegetable salad"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "5 almonds and 2 dates, a glass of milk"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "One bowl of vegetable pulao/chicken pulao with curd"));

            arrayList.add(new BmiCalculator.Menu("Saturday", "DietChart"));
            arrayList.add(new BmiCalculator.Menu("Breakfast" + "\n" + "(8:00-8:30AM)", "Parathas using multigrain with fruits/egg multigrain paratha unsweetened tea/coffee"));
            arrayList.add(new BmiCalculator.Menu("Lunch" + "\n" + "(2:00-2:30PM)", "Whole-grain chapati with rajma gravy/chicken curry with quinoa"));
            arrayList.add(new BmiCalculator.Menu("Evening" + "\n" + "(4:00-4:30PM)", "5 almonds and 2 dates, a glass of buttermilk"));
            arrayList.add(new BmiCalculator.Menu("Dinner" + "\n" + "(8:00-8:30PM)", "Two thin lentil pancakes with paneer tikka / grilled fish with flavoured rice"));


        }
        recyclerChart.setLayoutManager(new LinearLayoutManager(this));
        chartAdapter = new ChartAdapter(arrayList, this);
        recyclerChart.setAdapter(chartAdapter);
    }


}
