package hd.backend.dto;

import hd.backend.domain.Board;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@NoArgsConstructor
@Data
public class BoardListResult {
    private Page<Board> list;
    private int page;
    private int size;
    private long totalCount;
    private long totalPageCount;
    public BoardListResult(int page, long totalCount, int size, Page<Board> list){
        this.page = page;
        this.totalCount = totalCount;
        this.size = size;
        this.list = list;
        this.totalPageCount = calTotalPageCount();
    }
    private long calTotalPageCount(){
        long tpc = totalCount/size;
        if(totalCount%size != 0) tpc++;
        return tpc;
    }
}

