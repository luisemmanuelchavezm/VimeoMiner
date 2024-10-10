package AISS.vimeo.controller;

import AISS.vimeo.model.VMTransform;
import AISS.vimeo.model.Channel.Channel;
import AISS.vimeo.model.VM.VMChannel;
import AISS.vimeo.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/vimeo/channel")
@Tag(name = "Channel", description = "Endpoints para la gestión de canales de Vimeo")
public class ChannelController {

    @Autowired
    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener un canal de Vimeo",
            description = "Obtener un objeto de canal especificando su ID",
            tags = { "canales", "get" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Canal encontrado", content = { @Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Canal no encontrado", content = { @Content(schema = @Schema()) })
    })
    public Channel findOne(@Parameter(description = "ID del canal que se desea obtener")@PathVariable String id,
                           @Parameter(description = "Número máximo de videos a obtener")@RequestParam(required = false, defaultValue = "10") String maxVideos,
                           @Parameter(description = "Número máximo de comentarios a obtener")@RequestParam(required = false, defaultValue = "10") String maxComments
    ) {
        Channel channel = channelService.findChannel(id, maxVideos, maxComments);
        return channel;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    @Operation(
            summary = "Crear un canal de Vimeo",
            description = "Crear un nuevo canal especificando su ID",
            tags = { "canales", "post" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Canal creado exitosamente", content = { @Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description="Solicitud inválida", content = { @Content(schema = @Schema()) })
    })
    public void create(@Parameter(description = "ID del canal que se desea crear")@PathVariable String id,
                       @Parameter(description = "Número máximo de videos a crear")@RequestParam(required = false, defaultValue = "10") String maxVideos,
                       @Parameter(description = "Número máximo de comentarios a crear")@RequestParam(required = false, defaultValue = "10") String maxComments) {
        Channel channel = findOne(id, maxVideos, maxComments);
        VMChannel channelVm = VMTransform.ofChannel(channel);
        channelService.createChannel(channelVm);
    }



}