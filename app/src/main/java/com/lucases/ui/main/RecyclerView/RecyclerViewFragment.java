package com.lucases.ui.main.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lucases.CardView;
import com.lucases.MyAdapter;
import com.lucases.R;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private ArrayList<CardView> itemList;
    private RecyclerView recyclerView;
    public static MyAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_recycler_fragment, container, false);

        itemList = new ArrayList<>();
        /*int[] idPersonaggi = {R.drawable.banjo_and_kazooie,
            R.drawable.bayonetta,
            R.drawable.bowser,
            R.drawable.bowser_jr,
            R.drawable.byleth,
            R.drawable.captain_falcon,
            R.drawable.chrom,
            R.drawable.cloud,
            R.drawable.corrin,
            R.drawable.daisy,
            R.drawable.dark_pit,
            R.drawable.dark_samus,
            R.drawable.diddy_kong,
            R.drawable.donkey_kong,
            R.drawable.dr_mario,
            R.drawable.duck_hunt,
            R.drawable.falco,
            R.drawable.fox,
            R.drawable.ganondorf,
            R.drawable.greninja,
            R.drawable.hero,
            R.drawable.ice_climbers,
            R.drawable.ike,
            R.drawable.incineroar,
            R.drawable.inkling,
            R.drawable.isabelle,
            R.drawable.jigglypuff,
            R.drawable.joker,
            R.drawable.ken,
            R.drawable.king_dedede,
            R.drawable.king_k_rool,
            R.drawable.kirby,
            R.drawable.link,
            R.drawable.little_mac,
            R.drawable.lucario,
            R.drawable.lucas,
            R.drawable.lucina,
            R.drawable.luigi,
            R.drawable.mario,
            R.drawable.marth,
            R.drawable.mega_man,
            R.drawable.meta_knight,
            R.drawable.mewtwo,
            R.drawable.mii_brawler,
            R.drawable.mii_gunner,
            R.drawable.mii_fighter,
            R.drawable.minmin,
            R.drawable.mr_game_and_watch,
            R.drawable.ness,
            R.drawable.olimar,
            R.drawable.pac_man,
            R.drawable.piranha_plant,
            R.drawable.palutena,
            R.drawable.peach,
            R.drawable.pichu,
            R.drawable.pikachu,
            R.drawable.pit,
            R.drawable.pokemon_trainer,
            R.drawable.richter,
            R.drawable.ridley,
            R.drawable.rob,
            R.drawable.robin,
            R.drawable.rosalina_and_luma,
            R.drawable.roy,
            R.drawable.ryu,
            R.drawable.samus,
            R.drawable.sheik,
            R.drawable.shulk,
            R.drawable.simon,
            R.drawable.snake,
            R.drawable.sonic,
            R.drawable.terry,
            R.drawable.toon_link,
            R.drawable.villager,
            R.drawable.wario,
            R.drawable.wii_fit_trainer,
            R.drawable.wolf,
            R.drawable.yoshi,
            R.drawable.young_link,
            R.drawable.zelda,
            R.drawable.zero_suit_samus};
        ArrayList<String> nomiPersonaggi = new ArrayList<>();
        //assegnazione personaggi
        {
            nomiPersonaggi.add("Banjo and Kazooie");
            nomiPersonaggi.add("Bayonetta");
            nomiPersonaggi.add("Bowser");
            nomiPersonaggi.add("Bowser Jr");
            nomiPersonaggi.add("Byleth");
            nomiPersonaggi.add("Captain Falcon");
            nomiPersonaggi.add("Chrom");
            nomiPersonaggi.add("Cloud");
            nomiPersonaggi.add("Corrin");
            nomiPersonaggi.add("Daisy");
            nomiPersonaggi.add("Dark Pit");
            nomiPersonaggi.add("Dark Samus");
            nomiPersonaggi.add("Diddy Kong");
            nomiPersonaggi.add("Donkey Kong");
            nomiPersonaggi.add("Dr Mario");
            nomiPersonaggi.add("Duck Hunt");
            nomiPersonaggi.add("Falco");
            nomiPersonaggi.add("Fox");
            nomiPersonaggi.add("Ganondorf");
            nomiPersonaggi.add("Greninja");
            nomiPersonaggi.add("Hero");
            nomiPersonaggi.add("Ice Climbers");
            nomiPersonaggi.add("Ike");
            nomiPersonaggi.add("Incineroar");
            nomiPersonaggi.add("Inkling");
            nomiPersonaggi.add("Isabelle");
            nomiPersonaggi.add("Jigglypuff");
            nomiPersonaggi.add("Joker");
            nomiPersonaggi.add("Ken");
            nomiPersonaggi.add("King Dedede");
            nomiPersonaggi.add("King K. Rool");
            nomiPersonaggi.add("Kirby");
            nomiPersonaggi.add("Link");
            nomiPersonaggi.add("Little Mac");
            nomiPersonaggi.add("Lucario");
            nomiPersonaggi.add("Lucas");
            nomiPersonaggi.add("Lucina");
            nomiPersonaggi.add("Luigi");
            nomiPersonaggi.add("Mario");
            nomiPersonaggi.add("Marth");
            nomiPersonaggi.add("Mega Man");
            nomiPersonaggi.add("Meta Knight");
            nomiPersonaggi.add("Mewtwo");
            nomiPersonaggi.add("Mii Brawler");
            nomiPersonaggi.add("Mii Gunner");
            nomiPersonaggi.add("Mii Fighter");
            nomiPersonaggi.add("Minmin");
            nomiPersonaggi.add("Mr Game&Watch");
            nomiPersonaggi.add("Ness");
            nomiPersonaggi.add("Olimar");
            nomiPersonaggi.add("Pac_man");
            nomiPersonaggi.add("Piranha Plant");
            nomiPersonaggi.add("Palutena");
            nomiPersonaggi.add("Peach");
            nomiPersonaggi.add("Pichu");
            nomiPersonaggi.add("Pikachu");
            nomiPersonaggi.add("Pit");
            nomiPersonaggi.add("Pokemon Trainer");
            nomiPersonaggi.add("Richter");
            nomiPersonaggi.add("Ridley");
            nomiPersonaggi.add("R.O.B.");
            nomiPersonaggi.add("Robin");
            nomiPersonaggi.add("Rosalina&Luma");
            nomiPersonaggi.add("Roy");
            nomiPersonaggi.add("Ryu");
            nomiPersonaggi.add("Samus");
            nomiPersonaggi.add("Sheik");
            nomiPersonaggi.add("Shulk");
            nomiPersonaggi.add("Simon");
            nomiPersonaggi.add("Snake");
            nomiPersonaggi.add("Sonic");
            nomiPersonaggi.add("Terry");
            nomiPersonaggi.add("Toon Link");
            nomiPersonaggi.add("Villager");
            nomiPersonaggi.add("Wario");
            nomiPersonaggi.add("Wii Fit Trainer");
            nomiPersonaggi.add("Wolf");
            nomiPersonaggi.add("Yoshi");
            nomiPersonaggi.add("Young Link");
            nomiPersonaggi.add("Zelda");
            nomiPersonaggi.add("Zero Suit Samus");
        }//assegnazione nomi personaggi
        for (int p = 0; p< idPersonaggi.size(); p++)
           itemList.add(new CardView(idPersonaggi[p] , nomiPersonaggi.get(p)));*/ //metodo con ArrayList

        {
            itemList.add(new CardView(R.drawable.banjo_and_kazooie, "Banjo and Kazooie"));
            itemList.add(new CardView(R.drawable.bayonetta, "Bayonetta"));
            itemList.add(new CardView(R.drawable.bowser, "Bowser"));
            itemList.add(new CardView(R.drawable.bowser_jr, "Bowser Jr"));
            itemList.add(new CardView(R.drawable.byleth, "Byleth"));
            itemList.add(new CardView(R.drawable.captain_falcon, "Captain Falcon"));
            itemList.add(new CardView(R.drawable.chrom, "Chrom"));
            itemList.add(new CardView(R.drawable.cloud, "Cloud"));
            itemList.add(new CardView(R.drawable.corrin, "Corrin"));
            itemList.add(new CardView(R.drawable.daisy, "Daisy"));
            itemList.add(new CardView(R.drawable.dark_pit, "Dark Pit"));
            itemList.add(new CardView(R.drawable.dark_samus, "Dark Samus"));
            itemList.add(new CardView(R.drawable.diddy_kong, "Diddy Kong"));
            itemList.add(new CardView(R.drawable.donkey_kong, "Donkey Kong"));
            itemList.add(new CardView(R.drawable.dr_mario, "Dr. Mario"));
            itemList.add(new CardView(R.drawable.duck_hunt, "Duck Hunt"));
            itemList.add(new CardView(R.drawable.falco, "Falco"));
            itemList.add(new CardView(R.drawable.fox, "Fox"));
            itemList.add(new CardView(R.drawable.ganondorf, "Ganondorf"));
            itemList.add(new CardView(R.drawable.greninja, "Greninja"));
            itemList.add(new CardView(R.drawable.hero, "Hero"));
            itemList.add(new CardView(R.drawable.ice_climbers, "Ice Climbers"));
            itemList.add(new CardView(R.drawable.ike, "Ike"));
            itemList.add(new CardView(R.drawable.incineroar, "Incineroar"));
            itemList.add(new CardView(R.drawable.inkling, "Inkling"));
            itemList.add(new CardView(R.drawable.isabelle, "Isabelle"));
            itemList.add(new CardView(R.drawable.jigglypuff, "Jigglypuff"));
            itemList.add(new CardView(R.drawable.joker, "Joker"));
            itemList.add(new CardView(R.drawable.ken, "Ken"));
            itemList.add(new CardView(R.drawable.king_dedede, "King Dedede"));
            itemList.add(new CardView(R.drawable.king_k_rool, "King K. Rool"));
            itemList.add(new CardView(R.drawable.kirby, "Kirby"));
            itemList.add(new CardView(R.drawable.link, "Link"));
            itemList.add(new CardView(R.drawable.little_mac, "Little Mac"));
            itemList.add(new CardView(R.drawable.lucario, "Lucario"));
            itemList.add(new CardView(R.drawable.lucas, "Lucas"));
            itemList.add(new CardView(R.drawable.lucina, "Lucina"));
            itemList.add(new CardView(R.drawable.luigi, "Luigi"));
            itemList.add(new CardView(R.drawable.mario, "Mario"));
            itemList.add(new CardView(R.drawable.marth, "Marth"));
            itemList.add(new CardView(R.drawable.mega_man, "Mega Man"));
            itemList.add(new CardView(R.drawable.meta_knight, "Meta Knight"));
            itemList.add(new CardView(R.drawable.mewtwo, "Mewtwo"));
            itemList.add(new CardView(R.drawable.mii_brawler, "Mii Brawler"));
            itemList.add(new CardView(R.drawable.mii_gunner, "Mii Gunner"));
            itemList.add(new CardView(R.drawable.mii_swordfighter, "Mii Swordfighter"));
            itemList.add(new CardView(R.drawable.minmin, "Minmin"));
            itemList.add(new CardView(R.drawable.mr_game_and_watch, "Mr Game & Watch"));
            itemList.add(new CardView(R.drawable.ness, "Ness"));
            itemList.add(new CardView(R.drawable.olimar, "Olimar"));
            itemList.add(new CardView(R.drawable.pac_man, "Pac Man"));
            itemList.add(new CardView(R.drawable.palutena, "Palutena"));
            itemList.add(new CardView(R.drawable.peach, "Peach"));
            itemList.add(new CardView(R.drawable.pichu, "Pichu"));
            itemList.add(new CardView(R.drawable.pikachu, "Pikachu"));
            itemList.add(new CardView(R.drawable.piranha_plant, "Piranha Plant"));
            itemList.add(new CardView(R.drawable.pit, "Pit"));
            itemList.add(new CardView(R.drawable.pokemon_trainer, "Pokemon Trainer"));
            itemList.add(new CardView(R.drawable.richter, "Richter"));
            itemList.add(new CardView(R.drawable.ridley, "Ridley"));
            itemList.add(new CardView(R.drawable.rob, "R.O.B."));
            itemList.add(new CardView(R.drawable.robin, "Robin"));
            itemList.add(new CardView(R.drawable.rosalina_and_luma, "Rosalina & Luma"));
            itemList.add(new CardView(R.drawable.roy, "Roy"));
            itemList.add(new CardView(R.drawable.ryu, "Ryu"));
            itemList.add(new CardView(R.drawable.samus, "Samus"));
            itemList.add(new CardView(R.drawable.sheik, "Sheik"));
            itemList.add(new CardView(R.drawable.shulk, "Shulk"));
            itemList.add(new CardView(R.drawable.simon, "Simon"));
            itemList.add(new CardView(R.drawable.snake, "Snake"));
            itemList.add(new CardView(R.drawable.sonic, "Sonic"));
            itemList.add(new CardView(R.drawable.terry, "Terry"));
            itemList.add(new CardView(R.drawable.toon_link, "Toon Link"));
            itemList.add(new CardView(R.drawable.villager, "Villager"));
            itemList.add(new CardView(R.drawable.wario, "Wario"));
            itemList.add(new CardView(R.drawable.wii_fit_trainer, "Wii Fit Trainer"));
            itemList.add(new CardView(R.drawable.wolf, "Wolf"));
            itemList.add(new CardView(R.drawable.yoshi, "Yoshi"));
            itemList.add(new CardView(R.drawable.young_link, "Young Link"));
            itemList.add(new CardView(R.drawable.zelda, "Zelda"));
            itemList.add(new CardView(R.drawable.zero_suit_samus, "Zero Suit Samus"));
        }// metodo statico
        adapter = new MyAdapter(itemList);
        buildRecyclerView(root);

        adapter.setOnItemClickListener((new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                itemList.get(position).click(root.getContext());
            }
        }));
        return root;
    }

    private void buildRecyclerView(View root) {
        recyclerView = root.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(root.getContext(), 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}