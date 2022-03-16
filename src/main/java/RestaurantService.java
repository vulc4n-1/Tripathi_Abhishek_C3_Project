import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    private Restaurant findRestaurant(String restaurantName)
    {
        Iterator<Restaurant> iterator = restaurants.iterator();
        while(iterator.hasNext())
        {
            Restaurant restaurant = iterator.next();
            if(restaurant.getName().equals(restaurantName))
            {
                return restaurant;
            }
        }
        return null;
    }


    public Restaurant findRestaurantByName(String restaurantName) throws RestaurantNotFoundException
    {
        Restaurant restaurant = findRestaurant(restaurantName);
        if (restaurant == null)
            throw new RestaurantNotFoundException(restaurantName);
        return restaurant;
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws RestaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
