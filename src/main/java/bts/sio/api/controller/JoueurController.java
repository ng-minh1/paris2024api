package bts.sio.api.controller;

import bts.sio.api.model.Joueur;
import bts.sio.api.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@Tag(name = "Joueurs", description = "API de gestion des joueurs")
public class JoueurController {

    @Autowired
    private JoueurService joueurService;

    /**
     * Read - Get all joueurs
     * @return - An Iterable object of Joueur full filled
     */
    @Operation(summary = "Récupérer tous les joueurs",
            description = "Récupère l'ensemble des joueurs disponibles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Liste des joueurs récupérée",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Joueur.class)) })
    })
    @GetMapping("/joueurs")
    public Iterable<Joueur> getJoueurs() {
        return joueurService.getJoueurs();
    }
}

