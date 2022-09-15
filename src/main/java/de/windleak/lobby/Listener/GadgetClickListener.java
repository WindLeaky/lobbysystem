package de.windleak.lobby.Listener;

import de.windleak.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GadgetClickListener implements Listener {
    private Inventory gadgetinventory;
    private Inventory toystickcolorinventory;

    public GadgetClickListener(){
        this.gadgetinventory = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Gadgets");
        this.toystickcolorinventory = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Select a color");
    }

    @EventHandler
    public void onGadgetClick(PlayerInteractEvent event){
        Player player = event.getPlayer();

        // ITEM IN GADGET INV TO SELECT THE ROCKET GADGET
        ItemStack gadgetrocket = new ItemStack(Material.STICK, 1);
        ItemMeta rocketmeta = gadgetrocket.getItemMeta();
        rocketmeta.setDisplayName(ChatColor.YELLOW + "Magic Toy Stick");
        List<String> rocketlore = new ArrayList<>();
        rocketlore.add(ChatColor.RESET + "" + ChatColor.RED + "Spawn magic firework rockets");
        rocketmeta.setLore(rocketlore);
        gadgetrocket.setItemMeta(rocketmeta);
        gadgetinventory.setItem(13, gadgetrocket);

        // ITEM IN GADGET INV TO SELECT THE LUFT SCHIEßEN GADGET

        // UNSELECT ITEM
        ItemStack unselectitem = new ItemStack(Material.BARRIER, 1);
        ItemMeta unselectitemmeta = unselectitem.getItemMeta();
        unselectitemmeta.setDisplayName(ChatColor.RED + "Unselect your gadget");
        unselectitem.setItemMeta(unselectitemmeta);

        gadgetinventory.setItem(26, unselectitem);


        if (player.getItemInHand().getType() == Material.BLAZE_ROD) {
            player.openInventory(gadgetinventory);
        }
    }

    @EventHandler
    public void selectRocketInvClick(InventoryClickEvent event){
        // RED MAGIC TOY STICK
        ItemStack redmagicstick = new ItemStack(Material.STICK, 1);
        ItemMeta redmagicstickmeta = redmagicstick.getItemMeta();
        redmagicstickmeta.setDisplayName(ChatColor.RED + "Red Magic Toy Stick");
        redmagicstick.setItemMeta(redmagicstickmeta);

        // YELLOW MAGIC TOY STICK
        ItemStack yellowmagicstick = new ItemStack(Material.STICK, 1);
        ItemMeta yellowmagicstickmeta = yellowmagicstick.getItemMeta();
        yellowmagicstickmeta.setDisplayName(ChatColor.YELLOW + "Yellow Magic Toy Stick");
        yellowmagicstick.setItemMeta(yellowmagicstickmeta);

        // GREEN MAGIC TOY STICK
        ItemStack greenmagicstick = new ItemStack(Material.STICK, 1);
        ItemMeta greenmagicstickmeta = greenmagicstick.getItemMeta();
        greenmagicstickmeta.setDisplayName(ChatColor.GREEN + "Green Magic Toy Stick");
        greenmagicstick.setItemMeta(greenmagicstickmeta);

        // CYAN MAGIC TOY STICK
        ItemStack cyanmagicstick = new ItemStack(Material.STICK, 1);
        ItemMeta cyanmagicstickmeta = cyanmagicstick.getItemMeta();
        cyanmagicstickmeta.setDisplayName(ChatColor.AQUA + "Aqua Magic Toy Stick");
        cyanmagicstick.setItemMeta(cyanmagicstickmeta);

        // BlUE MAGIC TOY STICK
        ItemStack bluemagicstick = new ItemStack(Material.STICK, 1);
        ItemMeta bluemagicstickmeta = bluemagicstick.getItemMeta();
        bluemagicstickmeta.setDisplayName(ChatColor.BLUE + "Blue Magic Toy Stick");
        bluemagicstick.setItemMeta(bluemagicstickmeta);

        // RED COLOR

        ItemStack redcolor = new ItemStack(Material.RED_WOOL, 1);
        ItemMeta redcolormeta = redcolor.getItemMeta();
        redcolormeta.setDisplayName(ChatColor.RED + "RED");
        redcolor.setItemMeta(redcolormeta);

        toystickcolorinventory.setItem(11, redcolor);

        // YELLOW COLOR

        ItemStack yellowcolor = new ItemStack(Material.YELLOW_WOOL, 1);
        ItemMeta yellowcolormeta = yellowcolor.getItemMeta();
        yellowcolormeta.setDisplayName(ChatColor.YELLOW + "YELLOW");
        yellowcolor.setItemMeta(yellowcolormeta);

        toystickcolorinventory.setItem(12, yellowcolor);

        // GREEN COLOR

        ItemStack greencolor = new ItemStack(Material.GREEN_WOOL, 1);
        ItemMeta greencolormeta = greencolor.getItemMeta();
        greencolormeta.setDisplayName(ChatColor.GREEN + "GREEN");
        greencolor.setItemMeta(greencolormeta);

        toystickcolorinventory.setItem(13, greencolor);


        // CYAN COLOR

        ItemStack cyancolor = new ItemStack(Material.CYAN_WOOL, 1);
        ItemMeta cyancolormeta = cyancolor.getItemMeta();
        cyancolormeta.setDisplayName(ChatColor.AQUA + "AQUA");
        cyancolor.setItemMeta(cyancolormeta);

        toystickcolorinventory.setItem(14, cyancolor);

        // BLUE COLOR

        ItemStack bluecolor = new ItemStack(Material.BLUE_WOOL, 1);
        ItemMeta bluecolormeta = bluecolor.getItemMeta();
        bluecolormeta.setDisplayName(ChatColor.BLUE + "BLUE");
        bluecolor.setItemMeta(bluecolormeta);

        toystickcolorinventory.setItem(15, bluecolor);





// RED; YELLOW; GREEN; AQUA; BLUE
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null) {
            if(!player.getInventory().contains(redmagicstick) && !player.getInventory().contains(yellowmagicstick) &&!player.getInventory().contains(greenmagicstick)
                    &&!player.getInventory().contains(cyanmagicstick) &&!player.getInventory().contains(bluemagicstick)) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.YELLOW + "Magic Toy Stick") && event.getCurrentItem().getType() == Material.STICK) {

                    player.closeInventory();
                    player.openInventory(toystickcolorinventory);
                }
            }
            else if(player.getInventory().contains(redmagicstick) || player.getInventory().contains(yellowmagicstick) || player.getInventory().contains(greenmagicstick)
                    || player.getInventory().contains(cyanmagicstick) || player.getInventory().contains(bluemagicstick)){
                if(event.getSlot() != 1) {
                    player.sendMessage(Main.getGadgetPrefix() + ChatColor.RED + "You've already selected this gadget!");
                }
                else{
                    player.sendMessage(Main.getGadgetPrefix() + ChatColor.RED +"You're really smart kid. Dang.");
                }
            }
        }
        // COLOR SELECTION
        if(event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null) {


            // ROCKET GADGET COLOR SELECTION
                if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.RED + "RED") && event.getCurrentItem().getType() == Material.RED_WOOL) {
                    player.closeInventory();
                    player.sendMessage(Main.getGadgetPrefix() + ChatColor.GRAY + "You selected the" + ChatColor.RED + " red " + ChatColor.YELLOW+ "Magic Toy Stick!");
                    player.getInventory().setItem(1, redmagicstick);
                    player.getInventory().setItem(36, new ItemStack(Material.AIR, 1));
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.YELLOW + "YELLOW") && event.getCurrentItem().getType() == Material.YELLOW_WOOL) {
                    player.closeInventory();
                    player.sendMessage(Main.getGadgetPrefix() + ChatColor.GRAY + "You selected the" + ChatColor.YELLOW + " yellow " + ChatColor.YELLOW + "Magic Toy Stick!");
                    player.getInventory().setItem(1, yellowmagicstick);
                    player.getInventory().setItem(36, new ItemStack(Material.AIR, 1));
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "GREEN") && event.getCurrentItem().getType() == Material.GREEN_WOOL) {
                    player.closeInventory();
                    player.sendMessage(Main.getGadgetPrefix() + ChatColor.GRAY + "You selected the" + ChatColor.GREEN + " green " + ChatColor.YELLOW + "Magic Toy Stick!");
                    player.getInventory().setItem(1, greenmagicstick);
                    player.getInventory().setItem(36, new ItemStack(Material.AIR, 1));
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.AQUA + "AQUA") && event.getCurrentItem().getType() == Material.CYAN_WOOL) {
                    player.closeInventory();
                    player.sendMessage(Main.getGadgetPrefix() + ChatColor.GRAY + "You selected the" + ChatColor.AQUA + " aqua " + ChatColor.YELLOW + "Magic Toy Stick!");
                    player.getInventory().setItem(1, cyanmagicstick);
                    player.getInventory().setItem(36, new ItemStack(Material.AIR, 1));
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.BLUE + "BLUE") && event.getCurrentItem().getType() == Material.BLUE_WOOL) {
                    player.closeInventory();
                    player.sendMessage(Main.getGadgetPrefix() + ChatColor.GRAY + "You selected the" + ChatColor.BLUE + " blue " + ChatColor.YELLOW + "Magic Toy Stick!");
                    player.getInventory().setItem(1, bluemagicstick);
                    player.getInventory().setItem(36, new ItemStack(Material.AIR, 1));
                }
            }
        if(event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null) {
            if(event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.RED + "Unselect your gadget")){
                if(player.getInventory().contains(redmagicstick) || player.getInventory().contains(yellowmagicstick) || player.getInventory().contains(greenmagicstick)
                        || player.getInventory().contains(cyanmagicstick) || player.getInventory().contains(bluemagicstick)
                        || player.getInventory().contains(bluemagicstick)){

                    player.closeInventory();
                    player.sendMessage(Main.getGadgetPrefix() + ChatColor.RED + "You unselected the gadget!");
                    player.getInventory().setItem(1, new ItemStack(Material.AIR, 1));
                }
                else if(!player.getInventory().contains(redmagicstick) && !player.getInventory().contains(yellowmagicstick) &&!player.getInventory().contains(greenmagicstick)
                        &&!player.getInventory().contains(cyanmagicstick) &&!player.getInventory().contains(bluemagicstick)){
                    player.sendMessage(Main.getGadgetPrefix() + ChatColor.RED + "You don't have a gadget selected!");

                }
                else{
                    player.sendMessage(Main.getGadgetPrefix() + ChatColor.RED + "You don't have a gadget selected!");
                }
            }
        }

        }
    }


