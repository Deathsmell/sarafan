package by.deathsmell.sarafan.controller;

import by.deathsmell.sarafan.exceptions.NotFoundExceptions;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MainController {

    private int counter = 4;

    private final List<Map<String, String>> massages = new ArrayList<>() {{
        add(new HashMap<>() {{
            put("id", "1");
            put("text", "First massage");
        }});
        add(new HashMap<>() {{
            put("id", "2");
            put("text", "Second massage");
        }});
        add(new HashMap<>() {{
            put("id", "3");
            put("text", "Third massage");
        }});
    }};

    @GetMapping
    public List<Map<String, String>> list() {
        return massages;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getMassage(id);
    }

    private Map<String, String> getMassage(@PathVariable String id) {
        return massages
                .stream()
                .filter(item -> item.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundExceptions::new);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> massage = getMassage(id);

        massages.remove(massage);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> massage) {
        massage.put("id", String.valueOf(counter++));

        massages.add(massage);

        return massage;
    }

    @PutMapping("{id}")
    public Map<String, String> update(
            @PathVariable String id,
            @RequestBody Map<String, String> massage
    ) {
        Map<String, String> massageFromDB = getMassage(id);

        massageFromDB.putAll(massage);
        massageFromDB.put("id",id);

        return massageFromDB;
    }
}
