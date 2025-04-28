package bts.sio.api.controller;

import bts.sio.api.model.Pays;
import bts.sio.api.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@Tag(name = "Pays", description = "API de gestion des pays des Jeux Olympiques Paris 2024")
public class PaysController {

    @Autowired
    private PaysService paysService;

    /**
     * Read - Get all pays
     * @return - An Iterable object of Pays full filled
     */
    @Operation(summary = "Récupérer tous les pays",
            description = "Récupère l'ensemble des pays disponibles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Liste des pays récupérée",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pays.class)) })
    })
    @GetMapping("/pays")
    public Iterable<Pays> getPays() {
        return paysService.getLesPays();
    }

    /**
     * Read - Get one pays
     * @param id The id of the pays
     * @return - A Pays object filled with data
     */
    @Operation(summary = "Récupérer un pays par son ID",
            description = "Recherche un pays spécifique par son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Pays trouvé",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pays.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Pays non trouvé",
                    content = @Content)
    })
    @GetMapping("/pays/{id}")
    public Pays getPays(
            @Parameter(description = "ID du pays à récupérer")
            @PathVariable("id") final Long id) {
        Optional<Pays> pays = paysService.getPays(id);
        return pays.orElse(null);
    }
}
