package entity;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> e0d6a41 (다대다 양방향 연관관계 Member, Team entity 추가)
=======
>>>>>>> 48984da (다대다 양방향 연관관계 Member, Team entity 추가)
=======

>>>>>>> 99b12c1 (push test)
=======

>>>>>>> 4c4eccd70deee0aea21a83cbc24f9f929a7ede8f
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
