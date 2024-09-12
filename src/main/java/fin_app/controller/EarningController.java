package fin_app.controller;

import fin_app.model.Earning;
import fin_app.services.EarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/earnings")
public class EarningController {

    @Autowired
    private EarningService earningService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Earning>> getEarningsByUserId(@PathVariable Long userId) {
        List<Earning> earnings = earningService.getEarningsByUserId(userId);
        return new ResponseEntity<>(earnings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Earning> getEarningById(@PathVariable Long id) {
        Earning earning = earningService.getEarningById(id);
        if (earning != null) {
            return new ResponseEntity<>(earning, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Earning> createEarning(@PathVariable Long userId, @RequestBody Earning earning) {
        Earning earningCreated = earningService.createEarning(userId, earning);
        if (earningCreated != null) {
            return new ResponseEntity<>(earningCreated, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Earning> updateEarning(@PathVariable Long id, @RequestBody Earning earning) {
        Earning updatedEarning = earningService.updateEarning(id, earning);
        if (updatedEarning != null) {
            return new ResponseEntity<>(updatedEarning, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEarning(@PathVariable Long id) {
        if (earningService.deleteEarning(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}