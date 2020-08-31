package step2.domain.point;

import step2.domain.Coordinate;
import step2.domain.direction.strategy.DiceGenerateStrategy;
import step2.domain.direction.strategy.DirectionGenerateStrategy;

import static step2.domain.Coordinate.LINE_START_COORDINATE;

public class PointGenerator {

	private final DirectionGenerateStrategy directionStrategy;

	public PointGenerator() {
		this.directionStrategy = new DiceGenerateStrategy();
	}

	public PointGenerator(DirectionGenerateStrategy directionStrategy) {
		this.directionStrategy = directionStrategy;
	}

	public Point generateNextPoint(Point previous, Coordinate coordinate) {
		return new Point(coordinate, directionStrategy.getNextDirection(previous.getDirection()));
	}

	public Point generateLineStartPoint() {
		return new Point(LINE_START_COORDINATE, directionStrategy.getDirectionToStart());
	}

	public Point generateLineEndPoint(Point previous, Coordinate endCoordinate) {
		return new Point(endCoordinate, directionStrategy.getDirectionToEnd(previous.getDirection()));
	}

}