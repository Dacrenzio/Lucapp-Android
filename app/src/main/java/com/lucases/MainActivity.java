package com.lucases;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<CardView> itemList;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<>();
        /*ArrayList<Integer> idPersonaggi = new ArrayList<>();
        ArrayList<String> nomiPersonaggi = new ArrayList<>();
        {
            idPersonaggi.add(R.drawable.banjo_and_kazooie);
            idPersonaggi.add(R.drawable.bayonetta);
            idPersonaggi.add(R.drawable.bowser);
            idPersonaggi.add(R.drawable.bowser_jr);
            idPersonaggi.add(R.drawable.byleth);
            idPersonaggi.add(R.drawable.captain_falcon);
            idPersonaggi.add(R.drawable.chrom);
            idPersonaggi.add(R.drawable.cloud);
            idPersonaggi.add(R.drawable.corrin);
            idPersonaggi.add(R.drawable.daisy);
            idPersonaggi.add(R.drawable.dark_pit);
            idPersonaggi.add(R.drawable.dark_samus);
            idPersonaggi.add(R.drawable.diddy_kong);
            idPersonaggi.add(R.drawable.donkey_kong);
            idPersonaggi.add(R.drawable.dr_mario);
            idPersonaggi.add(R.drawable.duck_hunt);
            idPersonaggi.add(R.drawable.falco);
            idPersonaggi.add(R.drawable.fox);
            idPersonaggi.add(R.drawable.ganondorf);
            idPersonaggi.add(R.drawable.greninja);
            idPersonaggi.add(R.drawable.hero);
            idPersonaggi.add(R.drawable.ice_climbers);
            idPersonaggi.add(R.drawable.ike);
            idPersonaggi.add(R.drawable.incineroar);
            idPersonaggi.add(R.drawable.inkling);
            idPersonaggi.add(R.drawable.isabelle);
            idPersonaggi.add(R.drawable.jigglypuff);
            idPersonaggi.add(R.drawable.joker);
            idPersonaggi.add(R.drawable.ken);
            idPersonaggi.add(R.drawable.king_dedede);
            idPersonaggi.add(R.drawable.king_k_rool);
            idPersonaggi.add(R.drawable.kirby);
            idPersonaggi.add(R.drawable.link);
            idPersonaggi.add(R.drawable.little_mac);
            idPersonaggi.add(R.drawable.lucario);
            idPersonaggi.add(R.drawable.lucas);
            idPersonaggi.add(R.drawable.lucina);
            idPersonaggi.add(R.drawable.luigi);
            idPersonaggi.add(R.drawable.mario);
            idPersonaggi.add(R.drawable.marth);
            idPersonaggi.add(R.drawable.mega_man);
            idPersonaggi.add(R.drawable.meta_knight);
            idPersonaggi.add(R.drawable.mewtwo);
            idPersonaggi.add(R.drawable.mii_brawler);
            idPersonaggi.add(R.drawable.mii_gunner);
            idPersonaggi.add(R.drawable.mii_fighter);
            idPersonaggi.add(R.drawable.minmin);
            idPersonaggi.add(R.drawable.mr_game_and_watch);
            idPersonaggi.add(R.drawable.ness);
            idPersonaggi.add(R.drawable.olimar);
            idPersonaggi.add(R.drawable.pac_man);
            idPersonaggi.add(R.drawable.piranha_plant);
            idPersonaggi.add(R.drawable.palutena);
            idPersonaggi.add(R.drawable.peach);
            idPersonaggi.add(R.drawable.pichu);
            idPersonaggi.add(R.drawable.pikachu);
            idPersonaggi.add(R.drawable.pit);
            idPersonaggi.add(R.drawable.pokemon_trainer);
            idPersonaggi.add(R.drawable.richter);
            idPersonaggi.add(R.drawable.ridley);
            idPersonaggi.add(R.drawable.rob);
            idPersonaggi.add(R.drawable.robin);
            idPersonaggi.add(R.drawable.rosalina_and_luma);
            idPersonaggi.add(R.drawable.roy);
            idPersonaggi.add(R.drawable.ryu);
            idPersonaggi.add(R.drawable.samus);
            idPersonaggi.add(R.drawable.sheik);
            idPersonaggi.add(R.drawable.shulk);
            idPersonaggi.add(R.drawable.simon);
            idPersonaggi.add(R.drawable.snake);
            idPersonaggi.add(R.drawable.sonic);
            idPersonaggi.add(R.drawable.terry);
            idPersonaggi.add(R.drawable.toon_link);
            idPersonaggi.add(R.drawable.villager);
            idPersonaggi.add(R.drawable.wario);
            idPersonaggi.add(R.drawable.wii_fit_trainer);
            idPersonaggi.add(R.drawable.wolf);
            idPersonaggi.add(R.drawable.yoshi);
            idPersonaggi.add(R.drawable.young_link);
            idPersonaggi.add(R.drawable.zelda);
            idPersonaggi.add(R.drawable.zero_suit_samus);
        }//assegnazione personaggi
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
            nomiPersonaggi.add("R.O.B");
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
           itemList.add(new CardView(idPersonaggi.get(p) , nomiPersonaggi.get(p)));*/ //metodo con ArrayList

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
            itemList.add(new CardView(R.drawable.mr_game_and_watch, "Mr Game&Watch"));
            itemList.add(new CardView(R.drawable.ness, "Ness"));
            itemList.add(new CardView(R.drawable.olimar, "Olimar"));
            itemList.add(new CardView(R.drawable.pac_man, "Pac Man"));
            itemList.add(new CardView(R.drawable.palutena, "Palutena"));
            itemList.add(new CardView(R.drawable.peach, "Peach"));
            itemList.add(new CardView(R.drawable.pichu, "Pichu"));
            itemList.add(new CardView(R.drawable.pikachu, "Pikachu"));
            itemList.add(new CardView(R.drawable.pit, "Pit"));
            itemList.add(new CardView(R.drawable.piranha_plant, "Piranha Plant"));
            itemList.add(new CardView(R.drawable.pokemon_trainer, "Pokemon Trainer"));
            itemList.add(new CardView(R.drawable.richter, "Richter"));
            itemList.add(new CardView(R.drawable.ridley, "Ridley"));
            itemList.add(new CardView(R.drawable.rob, "R.O.B"));
            itemList.add(new CardView(R.drawable.robin, "Robin"));
            itemList.add(new CardView(R.drawable.rosalina_and_luma, "Rosalina&Luma"));
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
        buildRecyclerView();
        adapter.setOnItemClickListener((new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                itemList.get(position).click(getApplicationContext());
            }
        }));
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.research_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setIconifiedByDefault(false);

        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                adapter.getFilter().filter("");
                return true;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

}