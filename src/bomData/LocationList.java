package bomData;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class LocationList implements Iterable<Location>
{
	Vector<Location> locations = new Vector<Location>();
	// For searching
	Vector<String> locNames = new Vector<String>();
	
	public LocationList()
	{
	}
	
	public void add(Location l)
	{
		locations.add(l);
		locNames.add(l.getName());
	}
	
	public static LocationList getAllFromServer() throws IOException {
		// RMIT Proxy Settings
		// System.setProperty("http.proxyHost", "aproxy.rmit.edu.au");
		// System.setProperty("http.proxyPort", "8080");
		LocationList locations = new LocationList();
		String[] states = {"vic", "nsw", "tas", "wa", "sa", "nt", "qld", "ant"};
		String url;
		String name;
		
		for(String state: states) {
			Document doc = Jsoup.connect("http://www.bom.gov.au/" + state + "/observations/" + state + "all.shtml").get();
			Elements tbodies = doc.select("tbody");
			Elements links = tbodies.select("a");
			for (Element link: links) {
				url = link.attr("href");
				if (url.contains("products") && !url.contains("#")) {
					url = "http://www.bom.gov.au" + url.replace("products", "fwo").replace("shtml", "json");
					name = link.text();
					// Some names have an asterisk on the page
					if(name.endsWith("*"))
					{
						name = name.substring(0, name.length()-1);
					}
					locations.add(new Location(name, url, state));
				}			
			}
		}
		return locations;
	}
	
	public Vector<Location> fuzzySearch(String key)
	{
		Vector<Location> locationsMatching = new Vector<Location>();
		for (int i = 0; i < locations.size(); ++i)
		{
			Location iLoc = locations.get(i);
			if(iLoc.getName().toLowerCase().contains(key.toLowerCase()))
			{
					locationsMatching.add(iLoc);			
			}
		}
		return locationsMatching;
	}

	@Override
	public Iterator<Location> iterator() 
	{
		// TODO Auto-generated method stub
		return locations.iterator();
	}
}
