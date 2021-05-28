package io.umss.app.br.broadcast_hb.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.umss.app.br.broadcast_hb.core.ClassChannel;
import io.umss.app.br.broadcast_hb.service.ClassChannelService;
import io.umss.app.br.broadcast_hb.util.AElog;
import io.umss.app.br.broadcast_hb.util.AEutil;
import io.umss.app.br.broadcast_hb.util.exception.response.custom.CustomRuntimeException;

@RestController
@RequestMapping("api/v1/classchannels")
public class ClassChannelResource {

    private final Logger logger = LoggerFactory.getLogger(ClassChannelResource.class);

    @Autowired
    private AEutil util;

    @Autowired
    private ClassChannelService service;

    @GetMapping
    public ResponseEntity<Object> findAll(HttpServletRequest request) {
        List<ClassChannel> objectList;
        HttpHeaders responseHeaders = new HttpHeaders();
        requestLog(request);

        objectList = service.findAll();

        responseHeaders.set("Custom-Message", "HTP/1.1 200 OK");
        return new ResponseEntity<Object>(objectList, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id, HttpServletRequest request) {
        Optional<ClassChannel> object;
        HttpHeaders responseHeaders = new HttpHeaders();
        requestLog(request);

        if (null == id) {
            throw new CustomRuntimeException(HttpStatus.BAD_REQUEST, 400, "Wrong request", "There is a to the param.");
        } else {
            object = service.findById(id);
            if (null == object) {
                throw new CustomRuntimeException(HttpStatus.NOT_FOUND, 404, "Not found",
                        "There is not records to the param.");
            }
        }

        responseHeaders.set("Custom-Message", "HTTP/1. 200 OK");
        return new ResponseEntity<Object>(Optional.of(object), responseHeaders, HttpStatus.OK);
    }

    private synchronized void requestLog(HttpServletRequest request) {
        AElog.info1(logger,
                util.getInetAddressPort() + " <= " + request.getRemoteHost() + " {method:" + request.getMethod()
                        + ", URI:" + request.getRequestURI() + ", query:" + request.getQueryString() + "}");
    }
}