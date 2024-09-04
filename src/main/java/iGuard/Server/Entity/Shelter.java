package iGuard.Server.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "shelter")
@Getter
@Setter
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shelterId;

    @Column(name = "facility_type")
    private String facilityType;

    @Column(name = "shelter_name")
    private String shelterName;

    @Column(name = "address")
    private String address;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @Column(name = "area")
    private Double area;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "has_fan")
    private Boolean hasFan;

    @Column(name = "has_air_conditioner")
    private Boolean hasAirConditioner;

    @Column(name = "is_open_at_night")
    private Boolean isOpenAtNight;

    @Column(name = "is_open_on_holidays")
    private Boolean isOpenOnHolidays;

    @Column(name = "allows_accommodation")
    private Boolean allowsAccommodation;

    @Column(name = "notes")
    private String notes;

    @Column(name = "management_agency")
    private String managementAgency;

    @Column(name = "management_agency_phone")
    private String managementAgencyPhone;

    @Column(name = "facility_type_name")
    private String facilityTypeName;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    @OneToMany(mappedBy = "shelter")
    private List<VisitedShelter> visitedShelters;

    @OneToMany(mappedBy = "shelter")
    private List<RecommendedShelter> recommendedShelters;

    @OneToMany(mappedBy = "shelter")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "shelter")
    private List<Review> reviews;

    @OneToMany(mappedBy = "shelter")
    private List<Job> jobs;
}
