package com.gulincover.other.controller.suggestionsRelated;

import com.gulincover.other.service.SuggestionsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("PostSuggestionsApi")
@RestController
public class PostSuggestionsApi {

    @Autowired
    private SuggestionsInfoService suggestionsInfoService;

    @ApiOperation("/rpc/post/suggestions")
    @PostMapping("/rpc/post/suggestions")
    public Integer postInsertSuggestions(@RequestBody Map<String, String> map) {
        return suggestionsInfoService.insertSuggestions(Long.parseLong(map.get("userId")), map.get("content"));
    }
}
