package app.doggy.googlemapssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.doggy.googlemapssample.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
    mapFragment.getMapAsync(this)
  }

  override fun onMapReady(map: GoogleMap) {
    val tokyo = LatLng(36.0, 140.0)
    map.addMarker(MarkerOptions().position(tokyo).title("Tokyo"))
    map.moveCamera(CameraUpdateFactory.newLatLng(tokyo))
  }
}
