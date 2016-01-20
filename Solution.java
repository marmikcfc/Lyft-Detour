  class GeoPoint{

  private String pointName;
  private Double lat,lon;
  
  public GeoPoint(String pn, Double la, Double lo){

    pointName=pn;
    lat=la;
    lon=lo;
  }


  public double getLat() {
      return lat;
    }

  public double getLon() {
      return lon;
    }

}


public class Solution {

  // Haversine Formula for distance
   public static double distance(double lat1, double lon1, double lat2, double lon2) {
      double theta = lon1 - lon2;
      double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
      dist = Math.acos(dist);
      dist = rad2deg(dist);
      dist = dist * 60 * 1.1515;
      return (dist);
    }

    //decimal degrees to radians
    public static double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
    }

    //radians to decimal degrees
    public static double rad2deg(double rad) {
      return (rad * 180.0 / Math.PI);
    }

    // Distance between two
    public static double distanceTwo(GeoPoint X, GeoPoint Y) {
      return distance(X.getLat(),X.getLon(),Y.getLat(),Y.getLon());
    }


    public static void main(String[] args) {
      GeoPoint A, B,C,D;

      //If the geopoints are given as Command Line Inputs
     if (args.length == 8) {
      A = new GeoPoint("A", Double.parseDouble(args[0]), Double.parseDouble(args[1]));
      B = new GeoPoint("B", Double.parseDouble(args[2]), Double.parseDouble(args[3]));
      C = new GeoPoint("C", Double.parseDouble(args[4]), Double.parseDouble(args[5]));
      D = new GeoPoint("D", Double.parseDouble(args[6]), Double.parseDouble(args[7]));
    } else {

      //if Command Line Input isn't given
      A = new GeoPoint("A", 43.345805, -100.351563);
      B = new GeoPoint("B", 37.042738, -120.742188);
      C = new GeoPoint("C", 51.416895, 10.742188);
      D = new GeoPoint("D", 47.298465, 106.367188);
}
        
      //Since the Graph is an isosceles trapezium we just need to find the shorter of two opposite sides
      Double distAB=distanceTwo(A,B);
      Double distCD=distanceTwo(C,D);

      Double distACBD=distanceTwo(A,C)+distanceTwo(B,D);
      if(distAB <= distCD ){
        System.out.println("Path CABD is the best route and the total distance to travel is:"+ (distACBD + distAB)+" Miles");
      }
      else{
        System.out.println("Path ABCD is the best routeand the total distance to travel is:"+ (distACBD + distAB));
      }
    
    

  }
}

