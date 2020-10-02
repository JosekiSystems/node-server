package net.corda.explorer.controller;

import net.corda.explorer.constants.MessageConstants;
import net.corda.explorer.exception.AuthenticationException;
import net.corda.explorer.exception.GenericException;
import net.corda.explorer.model.response.MessageResponseEntity;
import net.corda.explorer.model.common.Settings;
import net.corda.explorer.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class SettingsController {

    @Value("${servertoken}")
    private String servertoken;

    @Autowired
    private SettingsService settingsService;

    @GetMapping("settings")
    public MessageResponseEntity<?> getSettings(@RequestHeader(value="clienttoken") String clienttoken)  {
        // auth check
        if (!servertoken.equals(clienttoken)) {
            return MessageConstants.UNAUTHORIZED;
        }
        try{
            return new MessageResponseEntity<>(settingsService.getApplicationSettings());
        }catch (Exception e){
            throw new GenericException(e.getMessage());
        }
    }

    @PostMapping("settings/{type}")
    private MessageResponseEntity<Void> updateCorDappDirectory(@RequestHeader(value="clienttoken") String clienttoken, @RequestBody Settings settings, @PathVariable String type) {
        // auth check
        if (!servertoken.equals(clienttoken)) {
            return MessageConstants.UNAUTHORIZED;
        }
        try{
            return new MessageResponseEntity<>(settingsService.updateSettings(settings, type));
        }catch (Exception e){
            throw new GenericException(e.getMessage());
        }
    }
}