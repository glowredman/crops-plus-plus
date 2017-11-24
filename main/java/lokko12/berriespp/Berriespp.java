package lokko12.berriespp;

import lokko12.Proxies.*;
import lokko12.croploadcore.CropLoader;
import lokko12.croploadcore.config;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import ic2.api.item.IC2Items;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import net.minecraftforge.common.*;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "berriespp", name = "Berrys++", version = "F-0.01a")
public class Berriespp {

	@Instance(value = "Berrys++")
	public static Berriespp instance;
	public static Random random;

	public CropLoader cropTestL;
	// public CropLoader NameOfCropL;

	@SidedProxy(clientSide = "lokko12.Proxies.ClientProxy", serverSide = "lokko12.Proxies.Proxy")
	public static Proxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent preinit) {

		cropTestL = new CropLoader();
		cropAgentiaL = new CropLoader();
		config c = new config(preinit, "berriespp.cfg");
		cropTestL.load(c.tconfig, "CropTest");
		// NameOfCropL.load(c.tConfig, "NameOfCrop");
		c.tconfig.save();
	}

	@EventHandler
	public void load(FMLPreInitializationEvent load) {
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postinit) {
		cropTestL.register();
		// NameOfCropL.register();
	}

}