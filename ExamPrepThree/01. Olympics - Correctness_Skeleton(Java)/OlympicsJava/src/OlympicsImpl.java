import java.util.*;
import java.util.stream.Collectors;

public class OlympicsImpl implements Olympics {

    private Map<Integer, Competition> competitions;
    private Map<Integer, Competitor> competitors;

    public OlympicsImpl() {
        this.competitions = new HashMap<>();
        this.competitors = new HashMap<>();
    }


    @Override
    public void addCompetitor(int id, String name) {
        if (this.competitors.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        this.competitors.put(id, new Competitor(id, name));

    }

    @Override
    public void addCompetition(int id, String name, int score) {
        if (this.competitions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        this.competitions.put(id, new Competition(name, id, score));
    }

    @Override
    public void compete(int competitorId, int competitionId) {
        if (!this.competitions.containsKey(competitionId) || !this.competitors.containsKey(competitorId)) {
            throw new IllegalArgumentException();
        }
        Competition competition = this.competitions.get(competitionId);
        Competitor competitor = this.competitors.get(competitorId);
        competitor.setTotalScore(competitor.getTotalScore()+competition.getScore());
        competition.getCompetitors().add(competitor);
    }

    @Override
    public void disqualify(int competitionId, int competitorId) {
        if (!this.competitions.containsKey(competitionId) || !this.competitors.containsKey(competitorId)) {
            throw new IllegalArgumentException();
        }
        Competition competition = this.competitions.get(competitionId);
        Competitor competitor = this.competitors.get(competitorId);
        if(!competition.getCompetitors().contains(competitor)){
            throw new IllegalArgumentException();
        }
        competitor.setTotalScore(competitor.getTotalScore() - competition.getScore());
        competition.getCompetitors().remove(competitor);

    }

    @Override
    public Iterable<Competitor> findCompetitorsInRange(long min, long max) {
        List<Competitor> collect = this.competitors.values().stream().
                filter(competitor -> competitor.getTotalScore() > min).
                filter(competitor -> competitor.getTotalScore()<=max).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Iterable<Competitor> getByName(String name) {

        List<Competitor> collect = this.competitors.values().stream().filter(competitor -> competitor.getName().equals(name))
                .sorted((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).collect(Collectors.toList());
        if (collect.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return collect;

    }

    @Override
    public Iterable<Competitor> searchWithNameLength(int minLength, int maxLength) {
        List<Competitor> collect = this.competitors.values().stream().filter(competitor -> competitor.getName().length() >= minLength).
                filter(competitor -> competitor.getName().length() <= maxLength).
                sorted((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).collect(Collectors.toList());
        return collect.isEmpty() ? Collections.emptyList() : collect;
    }

    @Override
    public Boolean contains(int competitionId, Competitor comp) {
        if (!competitions.containsKey(competitionId)) {
            throw new IllegalArgumentException();
        }
        return this.competitions.get(competitionId).getCompetitors().contains(comp);

    }

    @Override
    public int competitionsCount() {
        return this.competitions.size();

    }

    @Override
    public int competitorsCount() {
        return this.competitors.size();
    }

    @Override
    public Competition getCompetition(int id) {
        Competition competition = this.competitions.get(id);
        if (competition == null) {
            throw new IllegalArgumentException();
        }
        return competition;
    }
}
