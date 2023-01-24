package com.example.springboat2.Controller;

import com.example.springboat2.Pojo.Tracker;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/tracker")
public class TrackerSystem {
    ArrayList<Tracker> track=new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Tracker> getTrack(){
        return track;
    }
    @PostMapping("/add")
    public String addTracker(@RequestBody Tracker tracker){
        track.add(tracker);
        return "Tracker Added!";
    }

    @PutMapping("/update/{index}")
    public String updateTrack(@PathVariable int index,@RequestBody Tracker tracker){
        track.set(index,tracker);
        return "Tracker Updated!";
    }
    @GetMapping("/get/(title)")
    public Tracker searchTrack(@PathVariable String title){
        for ( Tracker t:track){
              if(t.equals(title))
                  return t;
        }
         return  null;
    }
    @PutMapping("/change/{index}")
    public String changeTask(@PathVariable int index) {
        Tracker t1 = track.get(index);
        if (t1.isStatus() == false)
            t1.setStatus(true);
        else
            t1.setStatus(false);
        return "task status changed";
    }
}
