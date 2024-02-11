package com.wanted.preonboarding.ticket.domain;

import com.wanted.preonboarding.ticket.domain.code.ActiveType;
import com.wanted.preonboarding.ticket.domain.code.converter.ActiveTypeConverter;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "performance")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Performance {

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private UUID id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private int price;
    
    @Column(name = "round")
    private int round;
    
    @Column(name = "type")
    private int type;
    
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "is_reserve")
    @Convert(converter = ActiveTypeConverter.class)
    private ActiveType isReserve;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "performance", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<PerformanceSeatInfo> performanceSeatInfos;

    @OneToMany(mappedBy = "performance", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Reservation> reservations;
}
